package net.rarvolt.fuelstats;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddRefuelingActivity extends AppCompatActivity {

    private Date refuelingDate;
    private String currency;
    private String fuelAmountUnit = "L";
    private String mileageUnit = "km";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_refueling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        refuelingDate = new GregorianCalendar().getTime();
        currency = NumberFormat.getCurrencyInstance().getCurrency().toString();

        TextView refuelingDateText = (TextView) findViewById(R.id.refueling_date);
        assert refuelingDateText != null;
        refuelingDateText.setFocusableInTouchMode(false);
        refuelingDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(v);
            }
        });

        TextView fuelAmountUnitText = (TextView) findViewById(R.id.fuel_amount_unit);
        assert fuelAmountUnitText != null;
        fuelAmountUnitText.setText(fuelAmountUnit);

        TextView fuelPriceUnitText = (TextView) findViewById(R.id.fuel_price_unit);
        assert fuelPriceUnitText != null;
        fuelPriceUnitText.setText(String.format("%s/%s", currency, fuelAmountUnit));

        TextView mileageUnitText = (TextView) findViewById(R.id.mileage_unit);
        assert mileageUnitText != null;
        mileageUnitText.setText(mileageUnit);

        updateView();
    }


    private void updateView() {
        TextView refuelingDateText = (TextView) findViewById(R.id.refueling_date);
        assert refuelingDateText != null;

        refuelingDateText.setText(new SimpleDateFormat("E, d MMM y",
                getResources().getConfiguration().locale
        ).format(refuelingDate));
    }

    private DatePickerDialog.OnDateSetListener datePickerListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    refuelingDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
                    updateView();
                }
            };

    public void showDatePicker(View view) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(refuelingDate);
        DatePickerDialog dialog = new DatePickerDialog(this, datePickerListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }
}
