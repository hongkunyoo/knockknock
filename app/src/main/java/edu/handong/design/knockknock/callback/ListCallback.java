package sep.software.anicare.interfaces;

import java.util.List;

public interface ListCallback<E> {
	public void onCompleted(List<E> list, int count);
}
