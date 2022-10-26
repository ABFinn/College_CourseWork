;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname EulerProject) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;euler2
(define (sumFibs f1 f2 limit)
  ;base case
  (if (>= f2 limit)
      0
  ;recursive case
      ;if(f2%2==0)
      (if (= 0 (remainder f2 2))
          (+ f2 (sumFibs f2 (+ f1 f2) limit))
          (sumFibs f2 (+ f1 f2) limit)
          )
      )
  )

(define (prime_aux n i)
  (if (> i (sqrt n))
      #t
      ;recursive case
      (if (= (modulo n i) 0)
          #f
          (prime_aux n (+ i 2))
      )   
   )

  )

(define (isPrime x)
  (if (and (= (remainder x 2) 0)(not (= x 2)))    
      #false
      ;else call prime aux function
      (prime_aux x 3)
      )
  )


  ;if x is prime
  ;return x
  ;else find a prime factor of x, calling e3 on x that number


(define (findPrimeFactor x i)
  (if (and (= (remainder x i) 0) (equal? (isPrime i) #t))
      i
      (findPrimeFactor x (+ i 1))
      )
  )


(define (euler2 x)
  (sumFibs 1 2 x)
  )

(define (euler3 x)
  (if (equal? (isPrime x) #t)
      x
      (euler3 (/ x (findPrimeFactor x 2)))   
  )
  )
(define (sumOfSquares x i)
  (if (= x 0)
      i
      (+ (expt x 2) (sumOfSquares (- x 1) i))
      )
  )

(define (sum x)
  (if (= x 0)
      x
      (+ x (sum (- x 1)))
      )
  
  )
(define (euler6 x)
  (- (expt(sum x) 2) (sumOfSquares x 0)) 
  
  )

(define (countPrime count limit prime)
  (if (> count limit)
      (- prime 1)
      (if (equal? (isPrime prime) #t)
          (countPrime (+ count 1) limit (+ prime 1))
          (countPrime count limit (+ prime 1))
          )
      )
 
  )

(define (euler7 x)
  (countPrime 0 x 0)
  )


(define (sumOfPrime i limit)
  (if (> i limit)
      0
      (if (equal? (isPrime i) #t)
          (+ i (sumOfPrime (+ i 1) limit))
          (sumOfPrime (+ i 1) limit)
          )
      )

  )

(define (euler10 x)
  (sumOfPrime 2 x)

  )
