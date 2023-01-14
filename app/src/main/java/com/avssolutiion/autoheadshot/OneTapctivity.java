package com.avssolutiion.autoheadshot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.avssolutiion.autoheadshot.databinding.ActivityOneTapctivityBinding;

public class OneTapctivity extends AppCompatActivity implements MaxAdListener {

    ActivityOneTapctivityBinding binding;


    public ProgressDialog dialog;

    //applovin ads
    private MaxInterstitialAd interstitialAd;
    private MaxNativeAdLoader nativeAdLoader;
    private MaxAd nativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOneTapctivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);


        interstitialAd = new MaxInterstitialAd(getString(R.string.inter),this);
        interstitialAd.setListener(this);
        interstitialAd.loadAd();


        binding.onetap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isReady()){
                    interstitialAd.showAd();
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //todo: check if user is already is login
                            dialog.dismiss();
                            Toast.makeText(OneTapctivity.this, "Applied", Toast.LENGTH_SHORT).show();

                        }
                    },4000);
                }else {
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //todo: check if user is already is login
                            dialog.dismiss();
                            Toast.makeText(OneTapctivity.this, "Applied", Toast.LENGTH_SHORT).show();

                        }
                    },4000);
                }

            }
        });



        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.s1.setProgress(35);
        binding.s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.t1.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        binding.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv1.setBackground(getDrawable(R.drawable.rigt_conners));
                binding.tv2.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv3.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv4.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv5.setBackground(getDrawable(R.drawable.blanck_back));
            }
        });

        binding.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv1.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv2.setBackground(getDrawable(R.drawable.rigt_conners));
                binding.tv3.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv4.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv5.setBackground(getDrawable(R.drawable.blanck_back));
            }
        });

        binding.tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv1.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv2.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv3.setBackground(getDrawable(R.drawable.rigt_conners));
                binding.tv4.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv5.setBackground(getDrawable(R.drawable.blanck_back));
            }
        });

        binding.tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv1.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv2.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv3.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv4.setBackground(getDrawable(R.drawable.rigt_conners));
                binding.tv5.setBackground(getDrawable(R.drawable.blanck_back));
            }
        });

        binding.tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tv1.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv2.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv3.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv4.setBackground(getDrawable(R.drawable.blanck_back));
                binding.tv5.setBackground(getDrawable(R.drawable.rigt_conners));
            }
        });



    }

    @Override
    public void onAdLoaded(MaxAd ad) {

    }

    @Override
    public void onAdDisplayed(MaxAd ad) {

    }

    @Override
    public void onAdHidden(MaxAd ad) {

    }

    @Override
    public void onAdClicked(MaxAd ad) {

    }

    @Override
    public void onAdLoadFailed(String adUnitId, MaxError error) {

    }

    @Override
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {

    }
}