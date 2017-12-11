import org.junit.Test;

import com.MusicStore.Model.Member;
import com.MusicStore.dao.MemberDAO;
import com.MusicStore.daoImpl.MemberDAOImpl;

public class ControllerTest {
	private MemberDAO memberDAO = new MemberDAOImpl();

	@Test
	public void testAdd() throws Exception {
		Member member = new Member();
		member.setId("12345");
		member.setAddress("12345");
		member.setE_mail("!2345");
		member.setName("12345");
		member.setPass("12345");
		memberDAO.addMember(member);
		// Assert.assertEquals(expected, actual)
	}
}
