class ObjectManager{
	constructor(){
		this.objectArray=[]; //게임에 등장할 모든 종류의 오브젝트들을 모아놓을 배열
	}
	//의뢰받은 객체를 objectArray라는 명단에 넣기
	addObject(obj){
		this.objectArray.push(obj);
	}
	//의뢰받은 객체를 objectArray에서 제거하기
	removeObject(obj){
		console.log(this.objectArray.indexOf(obj));
		//화면에서 제거
		stage.removeChild(obj.div);
		//배열에서 제거
		this.objectArray.splice(this.objectArray.indexOf(obj),1);
	
	}
	//tick, render 처리
	tick(){
		for(var i=0; i<this.objectArray.length;i++){
			//console.log(i);
			this.objectArray[i].tick();
		}
	}
	render(){
		for(var i=0; i<this.objectArray.length;i++){
			//console.log(i);
			this.objectArray[i].render();
		}
	}
}