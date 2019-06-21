import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Main {
	@Test
	public void testSoma() {
		int result = 2 + 2;
   		assertThat(4, equalTo(result));
	}
}