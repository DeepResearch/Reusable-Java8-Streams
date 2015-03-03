import com.awesomeml.collection.lazy.factory.LazyDoubleFactory;
import com.awesomeml.collection.lazy.impl.LazyDoubleCollection;


public class Test {

	public static void main(String[] args) {
		final int size = 20000000;
		final double[] array = new double[size];
		for(int i = 0; i < size; i++){
			array[i] = i;
		}
		// TODO Auto-generated method stub
		final LazyDoubleCollection collection = LazyDoubleFactory.doubleSequence(array);
		
//		System.out.println(collection.head());
//		PrimitiveIterator.OfDouble iter = collection.iterator();
//		while(iter.hasNext()){
//			System.out.println(iter.nextDouble());
//		}
//		final DoubleStream stream = DoubleStream.of(1.0,2.0,3.0,4.0,5.0,6.0);
//		stream.filter(x -> x > 1.0);
		
		
	}

}
