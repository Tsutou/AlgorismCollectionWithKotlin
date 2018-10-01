fun main(args: Array<String>) {

    for (n in 1..100){

        if (n % 15 == 0) {
            print("FizzBuzz\n")
        } else if (n % 3 == 0) {
            print("Fizz\n")
        } else if (n % 5 == 0) {
            print("Buzz\n")
        } else {
            print(n.toString() + "\n")
        }
    }
}