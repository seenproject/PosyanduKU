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
import satella.app.posyanduku.models.Anak;

public class data_profile extends AppCompatActivity {

    public static Intent getActIntent(Activity activity) {
        return new Intent(activity, data_profile.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_profile);
        ImageView myImage=(ImageView) findViewById(R.id.imageView);


        Anak anaks= (Anak) getIntent().getSerializableExtra("anak");
        if(anaks!=null){
            VCard balita=new VCard("balita")
                    .setName(anaks.getNamaLengkap())
                    .setAddress(anaks.getTglLahir())
                    .setWebsite(anaks.getNoKK());
            Bitmap myBitmap= QRCode.from(balita).bitmap();
            myImage.setImageBitmap(myBitmap);
        }
    }
}
