package Common;

public class IRequest<T> {
	public String SooID;
	public String SooTimeSign;
	public String SooPublicID;

	public String getSooID() {
		return SooID;
	}

	public void setSooID(String sooID) {
		SooID = sooID;
	}

	public String getSooTimeSign() {
		return SooTimeSign;
	}

	public void setSooTimeSign(String sooTimeSign) {
		SooTimeSign = sooTimeSign;
	}

	public String getSooPublicID() {
		return SooPublicID;
	}

	public void setSooPublicID(String sooPublicID) {
		SooPublicID = sooPublicID;
	}

}
