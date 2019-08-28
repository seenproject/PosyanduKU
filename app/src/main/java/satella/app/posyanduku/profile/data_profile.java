package satella.app.posyanduku.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.scheme.VCard;

import satella.app.posyanduku.R;

public class data_profile extends AppCompatActivity {

    public static Intent getActIntent(Activity activity) {
        return new Intent(activity, data_profile.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_profile);
        ImageView myImage=(ImageView) findViewById(R.id.imageView);
        VCard puti=new VCard("Puti")
                .setName("apriani")
                .setAddress("Indonesia")
                .setCompany("studytutorial")
                .setPhoneNumber("258999")
                .setWebsite("56565565454545");
        Bitmap myBitmap= QRCode.from(puti).bitmap();
        myImage.setImageBitmap(myBitmap);
    }
}
