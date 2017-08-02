package cn.itcast.demo3;

//都写一个空参构造器
public class FushuException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FushuException(String msg) {
		super(msg);
	}

	public FushuException() {

	}
}
