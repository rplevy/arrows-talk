(ns arrows-talk.01-original-arrows)

(def foo {:a 1
          :b ["a"
              {:d 1
               :e 2}
              "c"]
          :c 3})

;; instead of

(dec
 (*
  (inc
   (:d
    (second
     (:b foo))))
  5))


(-> foo
    (:b)
    (second)
    (:d)
    (inc)
    (* 5)
    (dec))

;; which we'll express even more cleanly as

(-> foo
    :b
    second
    :d
    inc
    (* 5)
    dec)
