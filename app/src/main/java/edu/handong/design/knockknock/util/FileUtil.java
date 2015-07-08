//package edu.handong.design.knockknock.util;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Resources;
//import android.database.Cursor;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.Environment;
//import android.provider.MediaStore;
//import android.provider.MediaStore.Images.Media;
//import android.text.format.Time;
//
//import com.squareup.picasso.Picasso;
//
//import de.greenrobot.event.EventBus;
//import sep.software.anicare.AniCareApp;
//import sep.software.anicare.R;
//import sep.software.anicare.AniCareException;
//
//public class FileUtil {
//
//	public static final int GALLERY = 10;
//	public static final int CAMERA = 11;
//
//
//	public static Uri getOutputMediaFileUri(Resources resources){
//		return Uri.fromFile(getOutputMediaFile(resources));
//	}
//
//
//	public static File getOutputMediaFile(Resources resources){
//		// To be safe, you should check that the SDCard is mounted
//		// using Environment.getExternalStorageState() before doing this.
//		File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
//				Environment.DIRECTORY_PICTURES), resources.getString(R.string.app_name));
//
//		// This location works best if you want the created images to be shared
//		// between applications and persist after your app has been uninstalled.
//		// Create the storage directory if it does not exist
//		if (!mediaStorageDir.exists()){
//			if (!mediaStorageDir.mkdirs()){
//				return null;
//			}
//		}
//
//		// Create a media file name
//		Time time = new Time();
//		time.setToNow();
//		String timeStamp = time.format("%Y%m%d_%H%M%S");
//		return new File(mediaStorageDir.getPath() + File.separator + "IMG_"+ timeStamp + ".jpg");
//	}
//
//
//	public static File saveBitmapToFile(Context context, Uri uri, Bitmap bitmap){
//		File file = null;
//		try {
//			file = new File(uri.getPath());
//			FileOutputStream fos = new FileOutputStream(file);
//			bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
//			fos.close();
//		} catch (FileNotFoundException e) {
//			EventBus.getDefault().post(new AniCareException(AniCareException.TYPE.INTERNAL_ERROR, "saveBitmapToFile"));
//		} catch (IOException e) {
//            EventBus.getDefault().post(new AniCareException(AniCareException.TYPE.INTERNAL_ERROR, "saveBitmapToFile"));
//		}
//		return file;
//	}
//
//
//	public static void getMediaFromGallery(Activity activity){
//		Intent intent = new Intent(Intent.ACTION_GET_CONTENT, Media.EXTERNAL_CONTENT_URI);
//		intent.setType("image/*");
//        activity.startActivityForResult(Intent.createChooser(intent, activity.getResources().getString(R.string.select_picture)), GALLERY);
//	}
//
//
//	public static String getMediaPathFromGalleryUri(Context context, Uri mediaUri){
//		String[] filePathColumn = { Media.DATA };
//
//		Cursor cursor = context.getContentResolver().query(mediaUri, filePathColumn, null, null, null);
//		cursor.moveToFirst();
//
//		int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//		String imagePath = cursor.getString(columnIndex);
//		cursor.close();
//
//		return imagePath;
//	}
//
//
//	public static Uri getMediaFromCamera(Activity activity){
//		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//		Uri mediaUri = getOutputMediaFileUri(activity.getResources());
//		intent.putExtra(MediaStore.EXTRA_OUTPUT, mediaUri);
//        activity.startActivityForResult(intent, CAMERA);
//		return mediaUri;
//	}
//
//
//	public static Uri getMediaUriFromCamera(Context context, Intent data, Uri mediaUri){
//		if(mediaUri == null){
//			if(data == null){
//				mediaUri = getLastCaptureBitmapUri(context);
//			} else {
//				mediaUri = data.getData();
//				if(mediaUri == null){
//					// Intent pass data as Bitmap
//					Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//					mediaUri = getOutputMediaFileUri(context.getResources());
//					saveBitmapToFile(context, mediaUri, bitmap);
//				}
//			}
//		}
//		return mediaUri;
//	}
//
//
//	public static Uri getLastCaptureBitmapUri(Context context){
//		Uri uri =null;
//		String[] IMAGE_PROJECTION = {
//				MediaStore.Images.ImageColumns.DATA,
//				MediaStore.Images.ImageColumns._ID,
//		};
//		Cursor cursorImages = context.getContentResolver().query(
//				Media.EXTERNAL_CONTENT_URI,
//				IMAGE_PROJECTION, null, null,null);
//		if (cursorImages != null && cursorImages.moveToLast()) {
//			uri = Uri.parse(cursorImages.getString(0));
//			cursorImages.close();
//		}
//		return uri;
//	}
//
//
//	public static void deleteDirectoryTree(File fileOrDirectory) {
//		if (fileOrDirectory.isDirectory()) {
//			for (File child : fileOrDirectory.listFiles()) {
//				deleteDirectoryTree(child);
//			}
//		}
//		fileOrDirectory.delete();
//	}
//
//
//	public static void clearCache(){
//        deleteDirectoryTree(AniCareApp.getAppContext().getCacheDir());
//	}
//}
