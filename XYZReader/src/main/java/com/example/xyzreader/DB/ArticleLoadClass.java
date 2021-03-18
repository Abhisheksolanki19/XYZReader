package com.example.xyzreader.DB;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;

/**
 * Helper for loading a list of articles or a single article.
 */
public class ArticleLoadClass extends CursorLoader {
    private ArticleLoadClass(Context context, Uri uri) {
        super(context, uri, Query.PROJECTION, null, null, Itemsmodel.Items.DEFAULT_SORT);
    }

    public static ArticleLoadClass newAllArticlesInstance(Context context) {
        return new ArticleLoadClass(context, Itemsmodel.Items.buildDirUri());
    }

    public static ArticleLoadClass newInstanceForItemId(Context context, long itemId) {
        return new ArticleLoadClass(context, Itemsmodel.Items.buildItemUri(itemId));
    }

    public interface Query {
        String[] PROJECTION = {
                Itemsmodel.Items._ID,
                Itemsmodel.Items.TITLE,
                Itemsmodel.Items.PUBLISHED_DATE,
                Itemsmodel.Items.AUTHOR,
                Itemsmodel.Items.THUMB_URL,
                Itemsmodel.Items.PHOTO_URL,
                Itemsmodel.Items.ASPECT_RATIO,
                Itemsmodel.Items.BODY,
        };

        int _ID = 0;
        int TITLE = 1;
        int PUBLISHED_DATE = 2;
        int AUTHOR = 3;
        int THUMB_URL = 4;
        int PHOTO_URL = 5;
        int ASPECT_RATIO = 6;
        int BODY = 7;
    }
}
