package diyTag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FmtDate extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss e");
		String date = sdf.format(new Date());
		JspWriter jw = getJspContext().getOut();
		jw.write(date);
	}
	
}
