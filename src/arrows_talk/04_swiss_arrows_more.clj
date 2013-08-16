(ns arrows-talk.04-swiss-arrows-more
  (:require [swiss-arrows.core :refer [-<> -?<> -!>> -!<>]]))

;; nil shortcutting

(def foo {:a 1
          :b ["a"
              "c"
              {:d 1
               :e 3}]
          :c 3})

;; breaks
(-<> foo
     :d
     (+ 1 2 3 <>))

;; does not break, shortcuts instead
(-?<> foo
      :d
      (+ 1 2 3 <>))


;; non-updating

(-?<> foo
      :b
      (nth <> 2)
      (-!>> (def got-here))
      :e
      (+ 1 2 3 <>))

got-here
