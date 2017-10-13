package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

class i {
    static void a(ListView listView, int i) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
            }
        }
    }
}
