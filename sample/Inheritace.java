package sample;

public class Inheritace {
    class Welcome {
        protected String gl = "Good luck";
        public void honk() {
            System.out.println("Welcome!!!");
        }
    }

    class Glhf extends Welcome {
        private String hf = "Have fun";
        public  void main(String[] args) {
            Glhf glhf = new Glhf();
            glhf.honk();
            System.out.println(glhf.gl + " " + glhf.hf);
        }
    }
}
