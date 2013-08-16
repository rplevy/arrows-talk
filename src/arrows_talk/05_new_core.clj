(ns arrows-talk.05-new-core)

;; Takes an expression and a set of test/form pairs.
;; Threads the expression (via ->) through each form
;; for which the corresponding test expression (not threaded) is true.

(cond-> 1
        true inc
        false (* 42)
        (= 2 2) (* 3))


;; Binds name to expr, evaluates the first form in the lexical context
;; of that binding, then binds name to that result, repeating for each
;; successive form

(-> 84
    (/ 4)
    (as-> twenty-one          ; uses the value from ->
          (* 2 twenty-one)))  ; no threading here


;; nil-shortcutting (formerly core.incubator -?>)

; will break
(-> {:a :b} :c dec)

; will not break, shortcut instead
(some-> {:a :b} :c dec)


