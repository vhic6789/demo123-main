package com.example.demo123.dto;

public class GiaodichDTO {
	private String tieude;
	private String nguoimua;
	private String nguoiban;
	private String nguoitao;
	private String giatri;
	private String hour;
	private String minutes;

	public GiaodichDTO() {

	}

	public GiaodichDTO(String tieude, String nguoimua, String nguoiban, String nguoitao, String giatri,
			String hour, String minutes) {

		this.tieude = tieude;
		this.nguoimua = nguoimua;
		this.nguoiban = nguoiban;
		this.nguoitao = nguoitao;
		this.giatri = giatri;
		this.hour = hour;
		this.minutes = minutes;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getNguoimua() {
		return nguoimua;
	}

	public void setNguoimua(String nguoimua) {
		this.nguoimua = nguoimua;
	}

	public String getNguoiban() {
		return nguoiban;
	}

	public void setNguoiban(String nguoiban) {
		this.nguoiban = nguoiban;
	}

	public String getNguoitao() {
		return nguoitao;
	}

	public void setNguoitao(String nguoitao) {
		this.nguoitao = nguoitao;
	}

	public String getGiatri() {
		return giatri;
	}

	public void setGiatri(String giatri) {
		this.giatri = giatri;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public boolean empty() {
		if (this.giatri.equals("") || this.nguoiban.equals("") || this.nguoimua.equals("") || this.nguoitao.equals("")
				|| this.tieude.equals("") || this.hour.equals("") || this.minutes.equals(""))
			return true;
		return false;
	}

}
