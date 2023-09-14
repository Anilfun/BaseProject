package com.example.baseproject

 class GlobalEvent() {

     var flag = 0
     var parameter: Any? = null

     fun GlobalEvent(flag: Int) {
         this.flag = flag
     }

     fun GlobalEvent(flag: Int, parameter: Any?) {
         this.flag = flag
         this.parameter = parameter
     }

     companion object{
         @JvmStatic
         val FRAGMENT_BACK = 1
         val FRAGMENT_HOME = 1
     }

}