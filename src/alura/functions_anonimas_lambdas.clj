(ns alura.functions_anonimas_lambdas)

;Função sem parametro é uma função anônima


(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior"
[aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))



;The function below it is a simple function, and inclusive it is possible find write like this:
;(defn mais-caro-que-100?  [valor-bruto]  (> valor-bruto 100))

;The functions it is so simple that we can imagine utilizing her only one time.
;Instead we create a function and use as a parameter we can call the anonym function/without name.
;It is possible to call the anonym function with (fn [valor-bruto] (> valor-bruto 100)).

(println "função sem nome")
(fn [valor-bruto] (> valor-bruto 100))
;(println (valor-descontado mais-caro-que-100? 1000))
;(println (valor-descontado mais-caro-que-100? 100))

;We are doing same thing than above (mais-caro-que-100?) the difference is we're using (fn) to define a function.
;For us to test we will pass the function directly with one of the parameters next.

(println "função sem nome")

(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))


;Functions anonyms also called lambda functions, além de classes anônimas podem serem encontradas tanto em Clojure quanto
; ...outras linguagens

;Short forms of the code

(println (valor-descontado (fn [v] (> v 100)) 1000))
(println (valor-descontado (fn [v] (> v 100)) 100))

(println (valor-descontado (fn [v] (> v 100)) 1000))
(println (valor-descontado (fn [v] (> v 100)) 100))
