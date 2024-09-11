(ns alura.core
  (:gen-class))
;FUCNTIONS AND VECTOR


;Defining a variable

(def total-de-produtos 13)

(def total-de-produtos (+ total-de-produtos 3))
; total-de=produtos
; 16

;Vector

(def storage ["Bag" "Shirt"])

;(storage 0)
;=> "Bag"

;Function to count the length of elements
(count storage)
;=> 2

;To add an element. The result of the function conj is a vector that has "Bag" "Shirt" "Hat"
; The conj do not alter the content of the original vector. Storage is still "Bag" "Shirt"
(conj storage "Hat")
;=> ["Bag" "Shirt" "Hat"]

;To add and alter an element create a nre function that is assigned from the (conj storage "Hat")
(def storage (conj storage "Hat"))
(println storage)
; => ["Bag" "Shirt" "Hat"]


;FUNCTIONS AND ARGUMENTS (PARAMETERS)

(defn greetings []
  (println "------")
  (println "Welcome to the Indigo!"))

;This function is pure
(defn valor-descontado
  "Retorna o valor descontado que é 90% do valor bruto"
  [valor-bruto]
  (* valor-bruto 0.9)) ;this 0.9 wants to say that is 10% of discount on top of the valor-bruto

(println (valor-descontado 100))
; => 90.0


; redefining the function above
(defn valor-descontado2
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (* valor-bruto (- 1 0.10)))
;(valor-descontado 100)
; => 90.0

;another way is to use a variable let
(defn valor-descontado3
  "Retorna o valor com desconto de 10%."
  [valor-bruto]
  (let [desconto 0.10]     ;Why do Let receive a vector? (let [desconto 0.10])
    (* valor-bruto (- 1 desconto))))

;(valor-descontado 100)
; => 90.0

;another way is to use a variable let
(defn valor-descontado4
  "Retorna o valor com desconto de 10%."
  [valor-bruto]
  (let [desconto 0.10]     ;Why do Let receive a vector? (let [desconto 0.10])
    (println "Calculando desconto de" desconto)
    (* valor-bruto (- 1 desconto))))

;(valor-descontado 100)
; => 90.0

;changing the variable value

(defn valor-descontado5
  "Retorna o valor com desconto de 10%."
  [valor-bruto]
  (let [desconto (/ 10 100)]
    (* valor-bruto (- 1 desconto))))
; (valor-descontado5 100)
; => 90N bigint

(defn valor-descontado6
  "Retorna o valor com desconto de 10%."
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto (* valor-bruto taxa-de-desconto)]  ;here we set 2 variables taxa-de-desconto and desconto
    (println "Calculando desconto de " desconto)
     (- valor-bruto desconto)))
; (valor-descontado6 100)
; => 90N bigint

;CONDITIONALS AND LET MULTIPLO

(if (> 500 100)
  (println "maior")
  (println "menor ou igual"))
;=>maior

(if (> 50 100)
  (println "maior")
  (println "menor ou igual")) ;else
; => menor ou igual

(defn valor-descontado7
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
  (let [taxa-de-desconto (/ 10 100)
        desconto (* valor-bruto taxa-de-desconto)]  ;here we defined 2 variables taxa-de-desconto and desconto
    (println "Calculando desconto de " desconto)
    (- valor-bruto desconto))
  valor-bruto))   ;here is the else and its returning the valor-bruto if the conditional is false))

(valor-descontado7 1000)
;=> 900N
(valor-descontado7 100)
;=> 100

;Breaking it in smaller functions

(defn valor-descontado7
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]  ;here we defined 2 variables taxa-de-desconto and desconto
      (- valor-bruto desconto))
    valor-bruto))   ;here is the else and its returning the valor-bruto if the conditional is false))

(println (valor-descontado7 1000))
;=> 900N
(println (valor-descontado7 100))
;=> 100

; PREDICATE ? TRUE OR FALSE
(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))
(println (aplica-desconto? 1000))
;=>true
(println (aplica-desconto? 100))
;=>false

;Redefining the function valor-descontado

(defn valor-descontado8
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100"
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)  ;remember to certify to put the parameter on this case is [valor-bruto]
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]  ;here we defined 2 variables taxa-de-desconto and desconto
      (- valor-bruto desconto))
    valor-bruto))   ;here is the else and its returning the valor-bruto if the conditional is false))

(println (valor-descontado8 1000))
;=> 900N
(println (valor-descontado8 100))
;=> 100

;Redefining
(defn aplica-desconto?
  [valor-bruto]
  (println "chamando a versão redefinida")
  (if (> valor-bruto 100)
    true))                    ;here not using else
(println (aplica-desconto? 1000))
;=>true
(println (aplica-desconto? 100))
;=>nill
(println (valor-descontado8 1000))
;=>900N
(defn aplica-desconto?
  [valor-bruto]
  (println "chamando a versão when")
  (when (> valor-bruto 100)
    true))
;=>100


;Using version When it will return same thing
;When just return the true, it not exist the false case
(println (valor-descontado8 100))

(println (aplica-desconto? 1000))
;=>true
(println (aplica-desconto? 100))
;=>nill
(println (valor-descontado8 1000))
;=>900N
(println (valor-descontado8 100))
;=>100

;Using version only with the  > it will return same thing
; Simple and direct on point
(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(println (aplica-desconto? 1000))
;=>true
(println (aplica-desconto? 100))
;=>nill
(println (valor-descontado8 1000))
;=>900N
(println (valor-descontado8 100))
;=>100


;Função sem parametro é uma função anônima
; Funções são "coisas" é a maneira informal de dizer que aqui em Clojure funções são tratadas como algo muito importante, tão importantes quanto dados. Isto é, você pode trabalhar com símbolos que referenciam funções.
; Funções são "first class citizens". Inclusive você pode passá-las como argumento para outras funções, ou recebê-las como retorno de funções.
; Funções que recebem ou retornam funções são chamadas de "higher order functions".


(defn mais-caro-que-100?
  [valor-bruto]
  (println "clarifying that invo")
  (> valor-bruto 100))


(defn valor-descontado9
  "Retorna o valor com desconto de 10% se deve aplicar desconto."
  [aplica? valor-bruto]              ;here has 2 parameters.
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println "function with argument")
(println (valor-descontado9 mais-caro-que-100? 10000)) ;valor-descontado now receives 2 parameters. The arity is 2.
(println (valor-descontado9 mais-caro-que-100? 100))  ;


(defn mais-caro-que-100? [valor-bruto] (> valor-bruto 100)) ; same thing than (fn [valor-bruto] (> valor-bruto 100))

;Creating a function without name
(println "Function without name")
(fn [valor-bruto] (> valor-bruto 100)) ;same than function (defn mais-caro-que-100? [valor-bruto] (> valor-bruto 100))
(println (valor-descontado9 mais-caro-que-100? 1000))
(println (valor-descontado9 mais-caro-que-100? 100))

;Reducing the function above
(println "Function without name, anonymous function")       ;fn
(println (valor-descontado9 (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println (valor-descontado9 (fn [valor-bruto] (> valor-bruto 100)) 100))

;Some people would even reduce it even more. But it is not recommended since it is not clear.
;Here we are using the % to make the lambda function.
(println (valor-descontado9 (fn [v] (> v 100)) 1000))
(println (valor-descontado9 (fn [v] (> v 100)) 100))
(println (valor-descontado9 #(> %1 100) 1000))
(println (valor-descontado9 #(> %1 100) 1000))
(println (valor-descontado9 #(> % 100) 1000))
(println (valor-descontado9 #(> % 100) 1000))

;Another Example. It has many ways to create functions.
(def mais-caro-que-100? (fn [valor-bruto] (> valor-bruto 100))) ;utilizing lambda. Defining the symbol/variable as the function mais-caro-que-100?
(def mais-caro-que-100? #(> % 100))
(println (valor-descontado9 mais-caro-que-100? 1000))
(println (valor-descontado9 mais-caro-que-100? 100))


;Vector, Get and updates
