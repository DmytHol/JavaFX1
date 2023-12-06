package Scrutineer.Utils;




import java.util.ArrayList;

public class DataSetGeneric<E extends Measurable> extends ArrayList<E> implements java.io.Serializable, Cloneable, Iterable<E>, java.util.Collection<E>, java.util.List<E>, java.util.RandomAccess {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataSetGeneric() {
    }

    public java.util.List<E> getList() {
        return this;
    }

    public java.util.List<E> getList(Screener<E> elementScreener) {
        DataSetGeneric<E> res = new DataSetGeneric<>();
        for (E element : this) {
            if (elementScreener.test(element)) {
                res.add(element);
            }
        }
        return res;
    }

    public E getMax() {
        if (!this.isEmpty()) {
            E max = get(0);
            for (E element : this) {
                if (element.getMeasure() > max.getMeasure()) {
                    max = element;
                }
            }
            return max;
        } else {
            System.out.println("It is empty.");
            return null;
        }
    }

    public E getMin() {
        if (!this.isEmpty()) {
            E min = get(0);
            for (E element : this) {
                if (element.getMeasure() < min.getMeasure()) {
                    min = element;
                }
            }
            return min;
        } else {
            System.out.println("It is empty.");
            return null;
        }
    }

    public java.util.List<E> sortBy(java.util.Comparator<? super E> comparator) {
        DataSetGeneric<E> sortedList = this.clone();
        sortedList.sort(comparator);
        return sortedList;
    }

    @Override
    public DataSetGeneric<E> clone() {
        DataSetGeneric<E> clonedList = new DataSetGeneric<>();
        clonedList.addAll(this);
        return clonedList;
    }
}