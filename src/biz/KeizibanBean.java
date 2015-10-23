package biz;

public class KeizibanBean {

  //(1)データを保存する変数idを宣言します。
  private String name;
  private String posting_date;
  private String posting_context;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPosting_date() {
	return posting_date;
}
public void setPosting_date(String posting_date) {
	this.posting_date = posting_date;
}
public String getPosting_context() {
	return posting_context;
}
public void setPosting_context(String posting_context) {
	this.posting_context = posting_context;
}

//  //(2)変数idにデータを保存するメソッドを宣言します。
//  public void setName(String name) { this.name = name; }
//  public void setPosting_date(String posting_date){ this.posting_date = posting_date; }
//  public void setPosting_context(String posting_context) { this.posting_context = posting_context; }
//
//  //(3)変数idのデータを返すメソッドを宣言します。JSPの
//  //   <jsp:getProperty>タグを使用すると、このメソッド
//  //   が呼び出されます。
//  public String getName() { return this.name; }
//  public String posting_date() { return this.posting_date; }
//  public String posting_context() { return this.posting_context; }



}