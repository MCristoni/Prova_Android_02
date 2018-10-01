package com.fumec.prova02matheuscristoni;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class CustomCanvas extends View {

    private final String txtEscolhido;

    public CustomCanvas(Context context, String txtEscolhido) {
        super(context);
        this.txtEscolhido = txtEscolhido;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setARGB(255, 0, 0, 0);
        paint.setTextSize(50);
        canvas.drawText(txtEscolhido, getWidth()/2, getHeight()/2, paint);
    }
}
