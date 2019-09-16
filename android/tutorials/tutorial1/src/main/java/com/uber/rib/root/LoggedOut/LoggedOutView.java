package com.uber.rib.root.LoggedOut;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jakewharton.rxbinding2.view.RxView;
import com.uber.rib.tutorial1.R;

import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Top level view for {@link LoggedOutBuilder.LoggedOutScope}.
 */
class LoggedOutView extends LinearLayout implements LoggedOutInteractor.LoggedOutPresenter {

  private EditText editText;
  private Button loginButton;

  public LoggedOutView(Context context) {
    this(context, null);
  }

  public LoggedOutView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public LoggedOutView(Context context, @Nullable AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();

    editText = findViewById(R.id.edit_text);
    loginButton = findViewById(R.id.login_button);
  }

  @Override
  public Observable<String> loginName() {
    return RxView.clicks(loginButton)
        .map(new Function<Object, String>() {
          @Override
          public String apply(Object o) throws Exception {
            return editText.getText().toString();
          }
        });
  }
}
