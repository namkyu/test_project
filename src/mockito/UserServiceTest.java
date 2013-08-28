package mockito;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * @FileName : UserServiceTest.java
 * @Project : test_project
 * @Date : 2013. 8. 5.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class UserServiceTest {

	@Test
	public void testThenReturn() {
		UserManager manager = mock(UserManager.class);
		when(manager.getUserCount()).thenReturn(50);

		assertThat(50, is(manager.getUserCount()));
	}

	@Test
	public void testThenThrow() {
		UserManager manager = mock(UserManager.class);
		when(manager.getUserCount()).thenThrow(new RuntimeException());

		UserService userService = new UserService(manager);
		assertThat(-1, is(userService.getUserCount()));
	}

	@Test
	public void testThenAnswer() {
		UserManager manager = mock(UserManager.class);

		when(manager.getUserCount()).thenAnswer(new Answer<Integer>() {
			public int count = 0;

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				return ++count;
			}
		});

		UserService userService = new UserService(manager);
		assertThat(1, is(userService.getUserCount()));
		assertThat(2, is(userService.getUserCount()));
		assertThat(3, is(userService.getUserCount()));


	}
}
