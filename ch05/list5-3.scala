// 목록 5.3 Stream에 대한 프로그램 추적

Stream(1,2,3,4).map(_ + 10).filter(_ % 2 == 0).toList

cons(11, Stream(2,3,4)).map(_ + 10)).filter(_ % 2 == 0).toList

Stream(2,3,4).map(_ + 10).filter(_ % 2 == 0).toList

const(12, Stream(3,4).map(_ + 10)).filter(_ % 2 == 0)).toList

12 :: Stream(3,4).map(_ + 10).filter(_ % 2 == 0).toList

12 :: cons(13, Stream(4).map(_ + 10)).filter(_ % 2 == 0).toList

12 :: Stream(4).map(_ + 10).filter(_ % 2 == 0).toList

12 :: cons(14, Stream().map(_ + 10)).filter(_ % 2 == 0).toList

12 :: 14 :: Stream().map(_ + 10).filter(_ % 2 == 0).toList

12 :: 14 :: List()
