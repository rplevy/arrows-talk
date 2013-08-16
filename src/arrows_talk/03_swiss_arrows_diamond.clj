(ns arrows-talk.03-swiss-arrows-diamond
  (:require [swiss-arrows.core :refer [-<> -<>>]]))

;;  but what if you need to mix different thread positions

(def foo {:a 1
          :b ["a"
              "c"
              {:d 1
               :e 3}]
          :c 3})

(-> foo
    :b
    (nth 2)
    :e
    (#(/ 2 %)))

;; or

(->> foo
    :b
    (#(nth % 2))
    :e
    (/ 2))

;; instead

(-<> foo
     :b
     (nth <> 2)
     :e
     (/ 2 <>))

;; which can also be expressed as

(-<> foo
     :b
     (nth 2)
     :e
     (/ 2 <>))

;; or

(-<>> foo
      :b
      (nth <> 2)
      :e
      (/ 2))
