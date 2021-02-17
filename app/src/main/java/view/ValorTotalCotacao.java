package view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.corretagemapp.R;
import com.example.corretagemapp.models.CotacaoModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class ValorTotalCotacao extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valor_total_cotacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        verifyStoragePermission(this);
        ArrayList<CotacaoModel> cotacoes = getIntent().getParcelableArrayListExtra("dados");

        List listPrecosEnfermaria = new ArrayList();
        List listaPrecosApartamento = new ArrayList();

        for(int count = 0; count < cotacoes.size(); count ++){
            Log.i("Verificando lista", cotacoes.get(count).getEnfermaria_preco());
            listPrecosEnfermaria.add(Float.parseFloat(cotacoes.get(count).getEnfermaria_preco()));
        }
        for(int count = 0; count < cotacoes.size(); count ++){
            Log.i("Verificando lista", cotacoes.get(count).getEnfermaria_preco());
            listaPrecosApartamento.add(Float.parseFloat(cotacoes.get(count).getApartamento_preco()));
        }
        float soma = somarEnfermaria(listPrecosEnfermaria);
        Log.i("A Soma Enferemair: ", String.valueOf(soma));

        float somaP = somarApartamento(listaPrecosApartamento);
        Log.i("A Soma Apartamento", String.valueOf(somaP));

        Button printButton = findViewById(R.id.salve_print);
        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File result = takeScreenShot(getWindow().getDecorView().getRootView(), "result");
                if (result != null) {
                    Toast.makeText(getApplicationContext(), "Comprovante salvo com sucesso!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Ocorreu um erro ao salvar o comprovante!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    protected static File takeScreenShot(View view, String fileName) {
        Date now = new Date();
        CharSequence format = DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
        try {
            String dirPath = view.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + now + ".png";
            File fileDir = new File(dirPath);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            String path = dirPath + "/" + fileName + "-" + format + ".png";
            //view.setDrawingCacheEnabled(true);
            Bitmap bitmap = getBitmapFromView(view);
            //view.setDrawingCacheEnabled(false);
            File imageFile = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.PNG, quality, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return imageFile;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSION_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE

    };

    public static void verifyStoragePermission(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSION_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }


    public CotacaoAdapter.CotacaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cotacao_card, parent, false
        );
        return new CotacaoAdapter.CotacaoViewHolder(view);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Float somarEnfermaria(List<Float> listPrecoEnfermaria){
        float soma = 0;
        for(int count = 0; count < listPrecoEnfermaria.size(); count++){
            soma = soma + listPrecoEnfermaria.get(count);
        }
        return soma;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Float somarApartamento(List<Float> listPrecoApartamento){
        float somaP = 0;
        for(int count = 0; count < listPrecoApartamento.size(); count++){
            somaP = somaP + listPrecoApartamento.get(count);
        }
        return somaP;
}
}
