package cal.cn.edu.hstc.cal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    String str1 = "";
    String str2 = "";
    Button buttonC;
    Button buttonJia;
    Button buttonJian;
    Button buttonChen;
    Button buttonChu;
    Button buttonDengyu;
    Button temp;
   int buttons[];
    double result;
    double  result0;
    double  result1;
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str1 = "";
                str2 ="";
                tv.setText(str1);
                flag = 0;
            }
        });
        for (int i = 0 ;i<buttons.length;i++){
            temp = (Button) findViewById(buttons[i]);
            temp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    str1 = tv.getText().toString().trim();
                    str1 = str1 + String.valueOf(((Button)view).getText());
                    tv.setText(str1);
                }
            });
        }
        buttonListener(buttonJia,1);
        buttonListener(buttonJian,2);
        buttonListener(buttonChen,3);
        buttonListener(buttonChu,4);

        buttonDengyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result1 = Double.parseDouble(str1);
                if(flag == 1){
                    result = result1 + result0;
                }else if(flag == 2){
                    result = result0 - result1;
                }else if(flag == 3){
                    result = result1 * result0;
                }else if(flag == 4){
                    if (result1==0){
                        result=0;
                    }
                    else{
                        result = (result0/result1);
                    }

                }
                String str = (result + "").trim();
                tv.setText(str);
            }
        });
    }
    public void initButton(){
        tv = (TextView) this.findViewById(R.id.textView);
        str1 = String.valueOf(tv.getText());
        str2 = "";

        buttonC = (Button) this.findViewById(R.id.buttonc);
        buttonJia = (Button) this.findViewById(R.id.buttonJia);
        buttonJian = (Button) this.findViewById(R.id.buttonJian);
        buttonChen = (Button) this.findViewById(R.id.buttonChen);
        buttonChu = (Button) this.findViewById(R.id.buttonChufa);
        buttonDengyu = (Button) this.findViewById(R.id.buttonDenyu);

        buttons = new int[]{
                R.id.button0,R.id.button01,R.id.button02,R.id.button03,R.id.button04,R.id.button05,
                R.id.button06,R.id.Button07,R.id.button08,R.id.button09
        };

    }

    public  void buttonListener(Button button,final int id){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = tv.getText().toString().trim();
                result0 = Double.parseDouble(str);
                tv.setText("");
                flag = id;
            }
        });
    }
}
