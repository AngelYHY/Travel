/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.library.base;

import rx.Observable;

/**
 * Author:  Tau.Chen
 * Email:   1076559197@qq.com | tauchen1990@gmail.com
 * Date:    2015/3/9.
 * Description: the com.android.library.base com.android.project.activity.view
 */
public interface IView {

    void showLoading();

    void hide();

    void showException(Throwable ex);

    void showNetError();

    void showMsg(String msg);

    void showEmpty(String msg);

    void showEmpty();

    void showDialog(String content);

    void showDialog();

    void hideDialog();

    void onComplete();

    /*<T> Observable bindToLifecycle(Observable<T> observable);*/

    <T> Observable.Transformer<T, T> applySchedulers();
}
