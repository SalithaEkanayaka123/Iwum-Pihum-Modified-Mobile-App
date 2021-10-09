package com.example.uee_recipe_management.application.bookmark;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.firebaseImageUploading.Upload;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class AddItem extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private Uri imageUri;
    Button addItem;
    Button attachImage;
    ProgressBar progressBar;
    EditText name;
    EditText subName;
    EditText description;
    ImageView attachImageView;

    /** Firebase Extensions**/
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        addItem = findViewById(R.id.add_recipe_button);
        attachImage = findViewById(R.id.attach_image_button);
        attachImageView = findViewById(R.id.attach_image);
        progressBar = findViewById(R.id.progressBar);
        name = findViewById(R.id.recipe_name);
        subName = findViewById(R.id.sub_name);
        description = findViewById(R.id.description);

        /** Firebase Schema Definition **/
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

        attachImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mGetContent.launch("image/*");
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Upload File When Press the Upload Button **/
                if(mUploadTask != null && mUploadTask.isInProgress()){
                    Toast.makeText(AddItem.this, "Upload in Progress", Toast.LENGTH_SHORT).show();
                }
                uploadFile();
            }
        });
    }

    /** Image Attachment Deprecated Method **/
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageUri = data.getData();
            Picasso.with(this).load(imageUri).into(attachImageView);
        }
    }

    /** Image Attachment Updated Method **/
    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    imageUri = uri;
                    Picasso.with(getApplicationContext()).load(imageUri).into(attachImageView);
                }
            });

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }


    /** Upload File Method **/
    private void uploadFile () {
        if(imageUri != null){
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(imageUri));
            fileReference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    /** Deplay the progress bar filling animation **/
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(0);
                        }
                    }, 5000);
                    Toast.makeText(AddItem.this, "Upload Successful", Toast.LENGTH_SHORT).show();

                    /** Creating a Reference in the Realtime Database **/
                    Upload upload = new Upload(name.getText().toString(), subName.getText().toString(), taskSnapshot.getMetadata().getReference().getDownloadUrl().toString(), description.getText().toString());
                    String uploadId = mDatabaseRef.push().getKey();
                    mDatabaseRef.child(uploadId).setValue(upload);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(Exception e) {
                    Toast.makeText(AddItem.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot snapshot) {
                    double progress = ((100.0) * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                    progressBar.setProgress((int)progress);
                }
            });
        } else {
            Toast.makeText(this, "No File Selected", Toast.LENGTH_SHORT).show();
        }
    }
}