/*
Stream : 현실에서의 스트림은 물줄기, 지류 즉 물의 흐름을 의미하지만, 컴퓨터 분야에서는 흐름의 대상이 데이터이다..
이 때 실행 중인 프로그램으로 흘러 들어가는 모습을 Input이라 하고,
흘러 나오는 모습을 가리켜 Output이라 한다..(입출력 IO)
-------------------------------------------------------
6kbyte=1024*6
-------------------------------------------------------
<예외(Exception)>
에러 : 프로그램의 정상 수행을 불가능하게 만드는 요인
에러의 종류
1) Error (에러) - 프로그래머가 감당할 수 있는 범위 외의 요인
2) Exception (예외) - 프로그래머가 감당할 수 있는 범위의 요인
		Catched Exception : 컴파일 타임에 '강요'되는 예외
		Runtime Exception : 런타임시 발생하는 예외
*/
//p0104_res에 들어있는 1.jpg를 copy 디렉토리에 복원
package p0107;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

public class FileCopy{
	String origin="F:/java_developer/javaSE/project1227/src/res/p0104_res/1.jpg";
	String dest="F:/java_developer/javaSE/project1227/src/copy/sea.jpg";
	FileInputStream fis; //파일을 대상으로 한 입력 스트림
	FileOutputStream fos; //파일을 대상으로 한 출력 스트림
	public FileCopy(){
		//스트림을 생성하는 순간 파일에 관이 생성
		
		/*Runtime Exception은 처리를 강요하지는 않지만, 개발자가 예외 처리를 할 경우 프로그램은 비정상 종료의 가능성이 적어진다
		int[]arr=new int[3];
		arr[0]=5;
		arr[1]=7;
		arr[2]=3;
		arr[3]=9;
		*/
		//이 라인은 장차 문제가 발생할 가능성이 높으므로 안전 장치를 해야 한다..
		try{
			fis=new FileInputStream(origin);
			fos=new FileOutputStream(dest);
			System.out.println("파일 스트림이 생성되었습니다.....");
			//생성된 스트림으로 데이터 입력을 수행하자
			int data;
			while(true){
				data=fis.read(); //1byte 읽어들임
				if(data==-1)break; //break : while문 빠져나오는 기능
				System.out.print((char)data);
				//출력하자
				fos.write(data); //data 출력
			}
		}catch(FileNotFoundException f){
			f.printStackTrace(); //에러 원인을 stack 구조로 누적하여 출력
			System.out.println("파일을 찾을 수 없습니다......");
			/*
			try문에서 혹여나 에러가 발생하면 프로그램은 비정상종료가 되어버리므로,
			그 상황을 막기 위해 catch문을 준비해두면 실행부가 비정상 종료되는 것이 아니라, catch문으로 진입한다
			따라서 예외가 발생하더라도 이 영역에 적절한 처리를 할 수 있다. 이 것이 바로 예외처리의 목적이다
			*/
		}catch(IOException e){
			System.out.println("입출력 중 오류가 발생했습니다.....");
		}finally{
			//finally를 명시하면 try문도 catch문도 이 영역을 거쳐간다
			//->주로 스트림, db를 사용 후 닫을 때 사용한다
			try{
				fis.close();
			}catch(IOException e){
				System.out.println("스트림 종료 중 오류가 발생했습니다...");
			}
		}
	}
	public static void main(String[] args){
		new FileCopy();
	}
}
