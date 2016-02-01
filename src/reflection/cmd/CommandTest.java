package reflection.cmd;

import java.util.HashMap;
import java.util.Map;

public class CommandTest {

	public static void main(String[] args) throws Exception {

		String[] key = {"/member", "/report", "subId"};
		String[] classNames = {"reflection.cmd.MemberCommand"
							, "reflection.cmd.ReportCommand"
							, "reflection.cmd.SubIdCommand"};

		Map<String, Command> instanceMap = new HashMap<String, Command>();

		for (int i = 0; i < classNames.length; i++) {
			Class<?> clz = Class.forName(classNames[i]);
			Command cmd = (Command)clz.newInstance();
			instanceMap.put(key[i], cmd);
		}

		String target = "/member";
		Command cmd = instanceMap.get(target);
		cmd.job();
	}
}
