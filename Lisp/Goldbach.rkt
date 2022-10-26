;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname Goldbach) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
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
  (if (= x 1)
      #false
  (if (and (= (remainder x 2) 0)(not (= x 2)))    
      #false
      ;else call prime aux function
      (prime_aux x 3)
      )
  )
  )
(define (gb_aux a b x)
  (if
  )
  


(define (goldbach x)
  (if (= (modulo x 2) 1)
      "You did not give me an even number!"
      (gb_aux 2 (- x 2) 12)

  )
  )
