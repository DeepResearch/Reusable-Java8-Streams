import java.util.PrimitiveIterator;

import com.awesomeml.collection.lazy.factory.LazyDoubleFactory;
import com.awesomeml.collection.lazy.impl.LazyDoubleCollection;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final LazyDoubleCollection collection = LazyDoubleFactory.doubleSequence(1.0,2.0,3.0,4.0,5.0,6.0);
		System.out.println(collection.head());
		PrimitiveIterator.OfDouble iter = collection.iterator();
		while(iter.hasNext()){
			System.out.println(iter.nextDouble());
		}
		
	}

}
