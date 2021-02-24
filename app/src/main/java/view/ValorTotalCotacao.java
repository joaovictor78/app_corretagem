package view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corretagemapp.R;
import com.example.corretagemapp.models.CotacaoModel;
import com.example.corretagemapp.models.CotacaoModelPreco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;


public class ValorTotalCotacao extends AppCompatActivity {
    ImageView imageViewBanner;
    LinearLayout linearLayoutEnfermariaTitle;
    LinearLayout linearLayoutEnfermariaPrice;
    TextView textEnfermariaTitle;
    TextView textEnfermariaPrice;

    LinearLayout linearLayoutApartamentoTitle;
    LinearLayout linearLayoutApartamentoPrice;
    TextView textApartamentoTitle;
    TextView textApartamentoPrice;

    LinearLayout linearViewcarencia;
    TextView textCarencia;
    double somaApartamentoNacional;
    double somaApartamentoEstadual;
    double somaApartamentoMunicipal;

    double somaEnfermagemNacional;
    double somaEnfermagemEstadual;
    double somaEnfermagemMunicipal;

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CorretagemApp);
        setContentView(R.layout.activity_valor_total_cotacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        verifyStoragePermission(this);
        Button printButton = findViewById(R.id.salve_print);
        linearLayoutEnfermariaTitle = findViewById(R.id.title_enfe);
        linearLayoutEnfermariaPrice = findViewById(R.id.valor_enfe);
        linearLayoutApartamentoTitle = findViewById(R.id.title_apt);
        linearLayoutApartamentoPrice = findViewById(R.id.valor_apt);
        linearViewcarencia = findViewById(R.id.carencia_text);
        Bundle args = new Bundle();
        Bundle extras = getIntent().getExtras();
        int id_image = extras.getInt("id_image");
        imageViewBanner = findViewById(R.id.id_imageOperadoraSelecionada);
        imageViewBanner.setImageResource(id_image);
        ArrayList<CotacaoModel> cotacoes = getIntent().getParcelableArrayListExtra("dados");
        List<CotacaoModelPreco> listPrecosEnfermaria = new ArrayList();
        List<CotacaoModelPreco> listPrecosApartamento = new ArrayList();
        List<String> listCarencia = new ArrayList();
        List<String> listTitleApt = new ArrayList<>();
        List<String> listTitleEnferm = new ArrayList<>();
        cotacoes.forEach(cotacaoModel -> listPrecosEnfermaria.addAll(cotacaoModel.getListEnfermagemPreco()));
        cotacoes.forEach(cotacaoModel -> listPrecosApartamento.addAll(cotacaoModel.getListApartamentoPreco()));
        cotacoes.forEach(cotacaoModel -> listCarencia.addAll(cotacaoModel.getListCarencia()));
        listPrecosApartamento.forEach(cotacaoModelPreco -> listTitleApt.add(cotacaoModelPreco.getTitle()));
        listPrecosEnfermaria.forEach(cotacaoModelPreco -> listTitleEnferm.add(cotacaoModelPreco.getTitle()));
        Set<String> titleAptSet = new HashSet<String>(listTitleApt);
        Set<String> titleEnfermSet = new HashSet<String>(listTitleEnferm);
        Set<String> carenciaSet = new HashSet<String>(listCarencia);
        List<Double> listApartamentoNacional = new ArrayList();
        List<Double> listApartamentoEstadual = new ArrayList();
        List<Double> listApartamentoMunicipal = new ArrayList();

        List<Double> listEnfermariaNacional = new ArrayList();
        List<Double> listEnfermariaEstadual = new ArrayList();
        List<Double> listEnfermariaMunicipal = new ArrayList();


        listTitleApt.clear();
        listTitleApt.addAll(titleAptSet);

        listTitleEnferm.clear();
        listTitleEnferm.addAll(titleEnfermSet);

        listCarencia.clear();
        listCarencia.addAll(carenciaSet);

        listPrecosApartamento.forEach(cotacaoModelPreco -> {
            if (cotacaoModelPreco.getTitle().equals("Apartamento")) {
                listApartamentoNacional.add(Double.valueOf(cotacaoModelPreco.getPreco()));

            }
            if (cotacaoModelPreco.getTitle().equals("Apt Mun.")) {
                listApartamentoMunicipal.add(Double.valueOf(cotacaoModelPreco.getPreco()));
            }
            if (cotacaoModelPreco.getTitle().equals("Apt Est.")) {
                listApartamentoEstadual.add(Double.valueOf(cotacaoModelPreco.getPreco()));
            }
        });
        listPrecosEnfermaria.forEach(cotacaoModelPreco -> {
            if (cotacaoModelPreco.getTitle().equals("Enfermagem")) {
                listEnfermariaNacional.add(Double.parseDouble(cotacaoModelPreco.getPreco()));

            }
            if (cotacaoModelPreco.getTitle().equals("Enf Mun.")) {
                listEnfermariaMunicipal.add(Double.parseDouble(cotacaoModelPreco.getPreco()));
            }
            if (cotacaoModelPreco.getTitle().equals("Enf Est.")) {
                listEnfermariaEstadual.add(Double.parseDouble(cotacaoModelPreco.getPreco()));
            }
        });
        somaApartamentoNacional = somarCotacao(listApartamentoNacional);
        somaApartamentoEstadual = somarCotacao(listApartamentoEstadual);
        somaApartamentoMunicipal = somarCotacao(listApartamentoMunicipal);
        somaEnfermagemNacional = somarCotacao(listEnfermariaNacional);
        somaEnfermagemEstadual = somarCotacao(listEnfermariaEstadual);
        somaEnfermagemMunicipal = somarCotacao(listEnfermariaMunicipal);

        listTitleApt.forEach(title -> {
            textApartamentoTitle = new TextView(getApplicationContext());
            textApartamentoTitle.setText(title);
            linearLayoutApartamentoTitle.addView(textApartamentoTitle);
            textApartamentoPrice = new TextView(getApplicationContext());
            if (title.equals("Apartamento")) {
                textApartamentoPrice.setText(String.valueOf(somaApartamentoNacional));
            } else if (title.equals("Apt Mun.")) {
                textApartamentoPrice.setText(String.valueOf(somaApartamentoEstadual));
            } else if (title.equals("Apt Est.")) {
                textApartamentoPrice.setText(String.valueOf(somaApartamentoMunicipal));
            }
            linearLayoutApartamentoPrice.addView(textApartamentoPrice);
        });
        listTitleEnferm.forEach(title -> {
            textEnfermariaTitle = new TextView(getApplicationContext());
            textEnfermariaTitle.setText(title);
            linearLayoutEnfermariaTitle.addView(textEnfermariaTitle);
            textEnfermariaPrice = new TextView(getApplicationContext());
            if (title.equals("Enfermagem")) {
                textEnfermariaPrice.setText(String.valueOf(somaEnfermagemNacional));
            } else if (title.equals("Enf Mun.")) {
                textEnfermariaPrice.setText(String.valueOf(somaEnfermagemMunicipal));
            } else if (title.equals("Enf Est.")) {
                textEnfermariaPrice.setText(String.valueOf(somaEnfermagemEstadual));
            }
            linearLayoutEnfermariaPrice.addView(textEnfermariaPrice);
        });
        listCarencia.forEach(value -> {
            textCarencia = new TextView(getApplicationContext());
            textCarencia.setText(value);
            linearViewcarencia.addView(textCarencia);
        });


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


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected static File takeScreenShot(View view, String fileName) {
        Date now = new Date();
        CharSequence format = DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
        try {
            String dirPath = view.getContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath() + "/" + now + ".jpeg";
            File fileDir = new File(dirPath);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            String path = dirPath + "/" + fileName + "-" + format + ".jpeg";
            Bitmap bitmap = getBitmapFromView(view);
            File imageFile = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
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
    public Double somarCotacao(List<Double> list) {
        DecimalFormat df = new DecimalFormat("#.##");
        double soma_cotacao = 0.0;
        for (int count = 0; count < list.size(); count++) {
            soma_cotacao = soma_cotacao + list.get(count);
        }
        return Double.valueOf(df.format(soma_cotacao));
    }
}

