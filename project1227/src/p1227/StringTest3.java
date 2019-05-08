package p1227;

class StringTest3{
	public static void main(String[] args){
		String str="korea java";
		String str2="ÄÚ¸®¾Æ";
		System.out.println(str.charAt(3));
		System.out.println(str.indexOf('a'));
		System.out.println(str.indexOf(str.charAt(8)));
		System.out.println(str.length());
		System.out.println(str.replace(str.subSequence(0,5),str2.subSequence(0,3)));
		System.out.println(str.subSequence(2,7));
		System.out.println(str.replace("korea java","KOREA JAVA"));
		String str3="photo.jpg";
		String[] result=str3.split("\\.");
		System.out.println(result.length);
		System.out.println(result[0]);
		System.out.println(result[1]);
		String str4="a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.b.b.b.b.b.b.b.b.b.p.h.o.t.o.jpg";
		String[] result2=str4.split("\\.");
		for(int i=0;i<result2.length;i++){
			System.out.println(result2[i]);
		}
	}
}
