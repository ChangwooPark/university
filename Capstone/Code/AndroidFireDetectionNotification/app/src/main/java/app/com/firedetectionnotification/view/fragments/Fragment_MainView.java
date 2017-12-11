package app.com.firedetectionnotification.view.fragments;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import app.com.firedetectionnotification.R;
import app.com.firedetectionnotification.data.ReceiveData;
import app.com.firedetectionnotification.view.ViewManager;

/**
 * Created by Administrator on 2015-06-05.
 */
public class Fragment_MainView extends Fragment {

    LinearLayout layout_temperature;
    LinearLayout layout_Humidity;
    LinearLayout layout_smoke;
    LinearLayout layout_flame;

    ReceiveData receivedata;
    String temperatureData;

    XYMultipleSeriesDataset temperature_dataset;


    GraphicalView temperature_gv;
    CategorySeries temperature_series;
    Thread t;
    static int tem_check;
    static LinearLayout mjpeg;

    LinearLayout tem_laout;
    View tem_view;
    XYMultipleSeriesRenderer renderer;
    ViewManager viewmanager;

    //    String imgUrl = "http://tv03.search.naver.net/thm?size=120x150&quality=9&q=http://sstatic.naver.net/people/portrait/201403/20140324192115724.jpg";
String Url = "http://203.230.100.202:8080/?action=stream";
    Handler handler = new Handler();

    public XYMultipleSeriesRenderer renderer(){

        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setChartTitleTextSize(30);
        renderer.setLegendTextSize(15);

        return renderer;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = null;

        try{
            v = inflater.inflate(R.layout.fragment_mainview, container, false);
        }catch (InflateException e){

        }
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        layout_Humidity = (LinearLayout) view.findViewById(R.id.Humidity);
        layout_temperature = (LinearLayout) view.findViewById(R.id.Temperature);
        layout_smoke = (LinearLayout) view.findViewById(R.id.Smoke);
        layout_flame = (LinearLayout) view.findViewById(R.id.flame);
        viewmanager = new ViewManager();

        Temperature(view, layout_temperature);
        Humidity(view,layout_Humidity);
        Smoke(view,layout_smoke);
        Flame(view,layout_flame);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                new TemperatureTask().execute(null, null, null);
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 2000, 3000);


        receivedata = new ReceiveData();
        receivedata.execute();


//        int dataLength = data.length();
//        String temperatureData = data.substring(1,dataLength-1);
//        Log.d("hong", "temperatureData : " + temperatureData);

        if(tem_check==0) {

            Log.d("hong","tem_check0");
            tem_check = 0;
        }
            layout_temperature.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {

                        Fragment_Temperature f = new Fragment_Temperature();
                        ViewManager.GetInstance().SendToParameter(f);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        layout_Humidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Fragment_Humidity f = new Fragment_Humidity();
                    ViewManager.GetInstance().SendToParameter(f);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        layout_smoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Fragment_Smoke f = new Fragment_Smoke();
                    ViewManager.GetInstance().SendToParameter(f);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        layout_flame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Fragment_Flame f = new Fragment_Flame();
                    ViewManager.GetInstance().SendToParameter(f);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("hong","webviewclientclass ㅇㅋ");
            view.loadUrl(url);
            return true;
        }
    }

    public void Humidity(View view,LinearLayout Humidity) {
        // 표시할 수치값
        List<double[]> values = new ArrayList<double[]>();
        values.add(new double[] { 30,31,28,17,34,20,26,27,22,30,27,11 });

/** 그래프 출력을 위한 그래픽 속성 지정객체 */
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();

// 상단 표시 제목과 글자 크기
        renderer.setChartTitle("습도");
        renderer.setChartTitleTextSize(20);
// 분류에 대한 이름
        String[] titles = new String[] { "습도수치" };

// 항목을 표시하는데 사용될 색상값
        int[] colors = new int[] { Color.BLACK};

// 분류명 글자 크기 및 각 색상 지정
        renderer.setLegendTextSize(15);
        int length = colors.length;
        for (int i = 0; i < length; i++) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(colors[i]);
            renderer.addSeriesRenderer(r);
        }

// X,Y축 항목이름과 글자 크기
        renderer.setXTitle("시간");
        renderer.setYTitle("습도");
        renderer.setAxisTitleTextSize(12);

// 수치값 글자 크기 / X축 최소,최대값 / Y축 최소,최대값
        renderer.setLabelsTextSize(10);
        renderer.setXAxisMin(0.5);
        renderer.setXAxisMax(12.5);
        renderer.setYAxisMin(0);
        renderer.setYAxisMax(45);

// 그래프 위에 값 표시하기
        renderer.getSeriesRendererAt(0).setDisplayChartValues(true);
//        renderer.getSeriesRendererAt(1).setDisplayChartValues(true);
        renderer.getSeriesRendererAt(0).setChartValuesTextAlign(Paint.Align.RIGHT);
//        renderer.getSeriesRendererAt(1).setChartValuesTextAlign(Align.RIGHT);
        renderer.getSeriesRendererAt(0).setChartValuesTextSize(20);
//        renderer.getSeriesRendererAt(1).setChartValuesTextSize(20);

// X,Y축 라인 색상
        renderer.setAxesColor(Color.WHITE);

// 상단제목, X,Y축 제목, 수치값의 글자 색상
        renderer.setLabelsColor(Color.WHITE);

// X축의 표시 간격
        renderer.setXLabels(12);

// Y축의 표시 간격
        renderer.setYLabels(5);

// X,Y축 정렬방향
        renderer.setXLabelsAlign(Paint.Align.LEFT);
        renderer.setYLabelsAlign(Paint.Align.LEFT);

// X,Y축 스크롤 여부 ON/OFF
        renderer.setPanEnabled(false, false);

// ZOOM기능 ON/OFF
        renderer.setZoomEnabled(false, false);

// ZOOM 비율
        renderer.setZoomRate(1.0f);

// 막대간 간격
        renderer.setBarSpacing(0.5f);

// 설정 정보 설정
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        for (int i = 0; i < titles.length; i++) {
            CategorySeries series = new CategorySeries(titles[i]);
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                series.add(v[k]);
            }
            dataset.addSeries(series.toXYSeries());
        }

// 그래프 객체 생성
        GraphicalView gv = ChartFactory.getBarChartView(view.getContext(), dataset, renderer, BarChart.Type.STACKED);
//        GraphicalView gv = ChartFactory.getLineChartView(view.getContext(), dataset, renderer);

// 그래프를 LinearLayout에 추가
        Humidity.addView(gv);
    }


    public void Temperature(View view, LinearLayout temperature){
        // 표시할 수치값

        tem_view = view;
        tem_laout = temperature;
        List<double[]> values = new ArrayList<double[]>();
        if(temperature_series!=null) {
            temperature_series.clear();
        }
        ReceiveData receivedata = new ReceiveData();
        receivedata.execute();

        String[] data_tem;
        double[] inputData = new double[21];


        if(receivedata.sensorData!=null) {
            temperatureData = receivedata.sensorData;
            Log.d("hong", "sensordata : " + temperatureData);
            int datalength = temperatureData.length()-1;

            String data_temperature = temperatureData.substring(1,datalength);
            data_temperature = data_temperature.replaceAll("\"","");
            String dl[] = data_temperature.split(",");
            for(int i = 0; i<dl.length;i++){
//                Log.d("hong","dl : " + i + " : " + dl[i]);
//                Log.d("hong","test0");
                inputData[i] = Double.valueOf(dl[i]).doubleValue();
            }
            values.add(new double[] { inputData[0],inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],inputData[6],inputData[7],inputData[8],inputData[9],
                inputData[10],inputData[11],inputData[12],inputData[13],inputData[14],inputData[15],inputData[16],inputData[17],inputData[18],inputData[19]});
        }
        else{
            values.add(new double[] { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 });
            Log.d("hong","else values");
        }

//        values.add(new double[] { 10,16,14,20,11,16,17,10,12,20,22,19 });

//        values.add(new double[] { inputData[0],inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],inputData[6],inputData[7],inputData[8],inputData[9],
//                inputData[10],inputData[11],inputData[12],inputData[13],inputData[14],inputData[15],inputData[16],inputData[17],inputData[18],inputData[19]});
/** 그래프 출력을 위한 그래픽 속성 지정객체 */
        renderer = new XYMultipleSeriesRenderer();

// 상단 표시 제목과 글자 크기
        renderer.setChartTitle("온도");
        renderer.setChartTitleTextSize(20);
// 분류에 대한 이름
        String[] titles = new String[] { "온도수치" };

// 항목을 표시하는데 사용될 색상값
        int[] colors = new int[] { Color.LTGRAY };

// 분류명 글자 크기 및 각 색상 지정
        renderer.setLegendTextSize(15);
        int length = colors.length;
        for (int i = 0; i < length; i++) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(colors[i]);
            renderer.addSeriesRenderer(r);
        }

// X,Y축 항목이름과 글자 크기
        renderer.setXTitle("시간");
        renderer.setYTitle("온도");
        renderer.setAxisTitleTextSize(12);
// 수치값 글자 크기 / X축 최소,최대값 / Y축 최소,최대값
        renderer.setLabelsTextSize(10);
        renderer.setXAxisMin(0.5);
        renderer.setXAxisMax(20.5);
        renderer.setYAxisMin(0);
        renderer.setYAxisMax(45);
// 그래프 위에 값 표시하기
        renderer.getSeriesRendererAt(0).setDisplayChartValues(true);
//        renderer.getSeriesRendererAt(1).setDisplayChartValues(true);
        renderer.getSeriesRendererAt(0).setChartValuesTextAlign(Paint.Align.RIGHT);
//        renderer.getSeriesRendererAt(1).setChartValuesTextAlign(Align.RIGHT);
        renderer.getSeriesRendererAt(0).setChartValuesTextSize(20);
//        renderer.getSeriesRendererAt(1).setChartValuesTextSize(20);
// X,Y축 라인 색상
        renderer.setAxesColor(Color.WHITE);

// 상단제목, X,Y축 제목, 수치값의 글자 색상
        renderer.setLabelsColor(Color.WHITE);

// X축의 표시 간격
        renderer.setXLabels(12);
// Y축의 표시 간격
        renderer.setYLabels(5);
// X,Y축 정렬방향
        renderer.setXLabelsAlign(Paint.Align.LEFT);
        renderer.setYLabelsAlign(Paint.Align.LEFT);

// X,Y축 스크롤 여부 ON/OFF
        renderer.setPanEnabled(false, false);

// ZOOM기능 ON/OFF
        renderer.setZoomEnabled(false, false);

// ZOOM 비율
        renderer.setZoomRate(1.0f);

// 막대간 간격
        renderer.setBarSpacing(0.5f);

// 설정 정보 설정
        temperature_dataset = new XYMultipleSeriesDataset();
        for (int i = 0; i < titles.length; i++) {
            temperature_series = new CategorySeries(titles[i]);
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                temperature_series.add(v[k]);
            }
            temperature_dataset.addSeries(temperature_series.toXYSeries());
        }
// 그래프 객체 생성


            temperature_gv = ChartFactory.getBarChartView(tem_view.getContext(), temperature_dataset, renderer, BarChart.Type.STACKED);
//        GraphicalView gv = ChartFactory.getLineChartView(view.getContext(), dataset, renderer);
            tem_laout.addView(temperature_gv);

//        LayoutTemperature(gv, view);
        if(tem_check == 0) {
            Log.d("hong","testStart 호출체크");
//            testStart(view, temperature);
//            new TemperatureTask().execute(null, null, null);

        }
    }

    private class TemperatureTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Log.d("hong", "tem_ task진입");
//                if (android.os.Build.VERSION.SDK_INT > 9) {
//                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//                    StrictMode.setThreadPolicy(policy);
//                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }

        public void onPostExecute(Void result) {

           /* try {
                TimerTask task = new TimerTask()
                {
                    public void run()
                    {

                        Log.d("hong", "timer Run~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                        temperature_gv = ChartFactory.getBarChartView(tem_view.getContext(), temperature_dataset, renderer, BarChart.Type.STACKED);
////        GraphicalView gv = ChartFactory.getLineChartView(view.getContext(), dataset, renderer);
//                        tem_laout.addView(temperature_gv);
//                        Temperature(tem_view,tem_laout);*/
//            Temperature(tem_view, tem_laout);

//                        Temperature_Data();
//            layout_temperature.invalidate();

            Temperature_Data();

//            temperature_gv.invalidate();
//            temperature_gv.postInvalidate();
//            temperature_gv.repaint();
                 /*   }
                };
                Timer timer = new Timer();
                timer.schedule(task,3000,3000);
//                Temperature(tem_view,tem_laout);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        }
    }

    public void Temperature_Data(){
        temperature_series.clear();


        ReceiveData receivedata = new ReceiveData();
        receivedata.execute();

        String[] data_tem;
        double[] inputData = new double[21];
        if(receivedata.sensorData!=null) {
            temperatureData = receivedata.sensorData;
            Log.d("hong", "sensordata : " + temperatureData);
            int datalength = temperatureData.length()-1;

            String data_temperature = temperatureData.substring(1,datalength);
            data_temperature = data_temperature.replaceAll("\"","");
            String dl[] = data_temperature.split(",");
            Log.d("hong","data_tem!!!!!!!!!!!!!!!! : " + data_temperature);
            for(int i = 0; i<dl.length;i++){
//                Log.d("hong","dl : " + i + " : " + dl[i]);
//                Log.d("hong","test0");
                inputData[i] = Double.valueOf(dl[i]).doubleValue();
            }
        }

        List<double[]> values = new ArrayList<double[]>();
//        values.add(new double[] { 10,16,14,20,11,16,17,10,12,20,22,19 });
        values.add(new double[] { inputData[0],inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],inputData[6],inputData[7],inputData[8],inputData[9],
                inputData[10],inputData[11],inputData[12],inputData[13],inputData[14],inputData[15],inputData[16],inputData[17],inputData[18],inputData[19]});

        String[] titles = new String[] { "온도수치" };


// 설정 정보 설정
        temperature_dataset = new XYMultipleSeriesDataset();
        for (int i = 0; i < titles.length; i++) {
//            temperature_series = new CategorySeries(titles[i]);
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                temperature_series.add(v[k]);
            }

            temperature_dataset.addSeries(temperature_series.toXYSeries());
//            temperature_gv.repaint();
        }
        temperature_gv.invalidate();
        layout_temperature.invalidate();
//        temperature_gv.invalidate();
    }

    public void Smoke(View view, LinearLayout smoke) {
        // 표시할 수치값
        List<double[]> values = new ArrayList<double[]>();
        values.add(new double[] { 28,11,38,20,32,34,27,26,27,22,20,25 });

/** 그래프 출력을 위한 그래픽 속성 지정객체 */
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();

// 상단 표시 제목과 글자 크기
        renderer.setChartTitle("연기");
        renderer.setChartTitleTextSize(20);
// 분류에 대한 이름
        String[] titles = new String[] { "연기수치" };

// 항목을 표시하는데 사용될 색상값
        int[] colors = new int[] { Color.GRAY };

// 분류명 글자 크기 및 각 색상 지정
        renderer.setLegendTextSize(15);
        int length = colors.length;
        for (int i = 0; i < length; i++) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(colors[i]);
            renderer.addSeriesRenderer(r);
        }

// X,Y축 항목이름과 글자 크기
        renderer.setXTitle("시간");
        renderer.setYTitle("연기");
        renderer.setAxisTitleTextSize(12);

// 수치값 글자 크기 / X축 최소,최대값 / Y축 최소,최대값
        renderer.setLabelsTextSize(10);
        renderer.setXAxisMin(0.5);
        renderer.setXAxisMax(12.5);
        renderer.setYAxisMin(0);
        renderer.setYAxisMax(45);

// 그래프 위에 값 표시하기
        renderer.getSeriesRendererAt(0).setDisplayChartValues(true);
//        renderer.getSeriesRendererAt(1).setDisplayChartValues(true);
        renderer.getSeriesRendererAt(0).setChartValuesTextAlign(Paint.Align.RIGHT);
//        renderer.getSeriesRendererAt(1).setChartValuesTextAlign(Align.RIGHT);
        renderer.getSeriesRendererAt(0).setChartValuesTextSize(20);
//        renderer.getSeriesRendererAt(1).setChartValuesTextSize(20);

// X,Y축 라인 색상
        renderer.setAxesColor(Color.WHITE);

// 상단제목, X,Y축 제목, 수치값의 글자 색상
        renderer.setLabelsColor(Color.WHITE);

// X축의 표시 간격
        renderer.setXLabels(12);

// Y축의 표시 간격
        renderer.setYLabels(5);

// X,Y축 정렬방향
        renderer.setXLabelsAlign(Paint.Align.LEFT);
        renderer.setYLabelsAlign(Paint.Align.LEFT);

// X,Y축 스크롤 여부 ON/OFF
        renderer.setPanEnabled(false, false);

// ZOOM기능 ON/OFF
        renderer.setZoomEnabled(false, false);

// ZOOM 비율
        renderer.setZoomRate(1.0f);

// 막대간 간격
        renderer.setBarSpacing(0.5f);

// 설정 정보 설정
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        for (int i = 0; i < titles.length; i++) {
            CategorySeries series = new CategorySeries(titles[i]);
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                series.add(v[k]);
            }
            dataset.addSeries(series.toXYSeries());
        }

// 그래프 객체 생성
        GraphicalView gv = ChartFactory.getBarChartView(view.getContext(), dataset, renderer, BarChart.Type.STACKED);
//        GraphicalView gv = ChartFactory.getLineChartView(view.getContext(), dataset, renderer);

// 그래프를 LinearLayout에 추가
        smoke.addView(gv);
    }

    public void Flame(View view, LinearLayout flame) {
        // 표시할 수치값
        List<double[]> values = new ArrayList<double[]>();
        values.add(new double[] { 20,26,27,14,30,24,21,20,17,25,15,13 });

/** 그래프 출력을 위한 그래픽 속성 지정객체 */
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();

// 상단 표시 제목과 글자 크기
        renderer.setChartTitle("불꽃");
        renderer.setChartTitleTextSize(20);
// 분류에 대한 이름
        String[] titles = new String[] { "불꽃수치" };

// 항목을 표시하는데 사용될 색상값
        int[] colors = new int[] { Color.DKGRAY };

// 분류명 글자 크기 및 각 색상 지정
        renderer.setLegendTextSize(15);
        int length = colors.length;
        for (int i = 0; i < length; i++) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(colors[i]);
            renderer.addSeriesRenderer(r);
        }

// X,Y축 항목이름과 글자 크기
        renderer.setXTitle("시간");
        renderer.setYTitle("불꽃");
        renderer.setAxisTitleTextSize(12);

// 수치값 글자 크기 / X축 최소,최대값 / Y축 최소,최대값
        renderer.setLabelsTextSize(10);
        renderer.setXAxisMin(0.5);
        renderer.setXAxisMax(12.5);
        renderer.setYAxisMin(0);
        renderer.setYAxisMax(45);

// 그래프 위에 값 표시하기
        renderer.getSeriesRendererAt(0).setDisplayChartValues(true);
//        renderer.getSeriesRendererAt(1).setDisplayChartValues(true);
        renderer.getSeriesRendererAt(0).setChartValuesTextAlign(Paint.Align.RIGHT);
//        renderer.getSeriesRendererAt(1).setChartValuesTextAlign(Align.RIGHT);
        renderer.getSeriesRendererAt(0).setChartValuesTextSize(20);
//        renderer.getSeriesRendererAt(1).setChartValuesTextSize(20);

// X,Y축 라인 색상
        renderer.setAxesColor(Color.WHITE);

// 상단제목, X,Y축 제목, 수치값의 글자 색상
        renderer.setLabelsColor(Color.WHITE);

// X축의 표시 간격
        renderer.setXLabels(12);

// Y축의 표시 간격
        renderer.setYLabels(5);

// X,Y축 정렬방향
        renderer.setXLabelsAlign(Paint.Align.LEFT);
        renderer.setYLabelsAlign(Paint.Align.LEFT);

// X,Y축 스크롤 여부 ON/OFF
        renderer.setPanEnabled(false, false);

// ZOOM기능 ON/OFF
        renderer.setZoomEnabled(false, false);

// ZOOM 비율
        renderer.setZoomRate(1.0f);

// 막대간 간격
        renderer.setBarSpacing(0.5f);

// 설정 정보 설정
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        for (int i = 0; i < titles.length; i++) {
            CategorySeries series = new CategorySeries(titles[i]);
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                series.add(v[k]);
            }
            dataset.addSeries(series.toXYSeries());
        }

        GraphicalView gv = ChartFactory.getBarChartView(view.getContext(), dataset, renderer, BarChart.Type.STACKED);

        flame.addView(gv);
    }
}
