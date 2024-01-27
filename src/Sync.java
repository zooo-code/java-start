public class Sync {

    public class donate{

        private Long money;


        public Long addMoney(long money){
            this.money += money;
            return money;
        }
    }




    public synchronized void synchronizedMethod(){

    }

    public void someMethod() {
        // 비동기적인 코드

        synchronized (this) {
            // 동기화가 보장된 코드 블록
        }

        // 다시 비동기적인 코드
    }

}
