(ns set-glom.core-test
  (:require [clojure.test :refer :all]
            [set-glom.core :refer :all]))

(deftest get-line-test
  (testing "The function get-line should be defined"
    (is (function? get-line))))

(deftest parse-set-test
  (testing "Basic usage of parse-set"
    (is (= (parse-set "1 2 3") #{"1" "2" "3"})))
  (testing "Extra white spaces should be ignored"
    (is (= (parse-set "   aaa   bbb   ccc   ") #{"aaa" "bbb" "ccc"})))
  (testing "Duplicate values should be ignored"
    (is (= (parse-set "1 1 2 1 3") #{"1" "2" "3"}))))

(deftest display-sets-test
  (testing "The function display-sets should be defined"
    (is (function? display-sets))))

(deftest glom-sets-test
  (testing "Empty set should insert into empty list"
    (is (= (iterate-main '() #{}) '(#{}))))
  (testing "Distinct sets should insert separately"
    (is (= (iterate-main '(#{"x"} #{"y"} #{"z"}) #{"a" "b"}) '(#{"a" "b"} #{"x"} #{"y"} #{"z"}))))
  (testing "Intersecting sets should glom together"
    (is (= (iterate-main '(#{"1" "2"} #{"y"} #{"z"} #{"3" "4"}) #{"2" "3"}) '(#{"1" "2" "3" "4"} #{"y"} #{"z"})))))

(deftest iterate-main-test
  (testing "Empty set glommed with empty set should be an empty set"
    (is (= (glom-sets #{} #{}) #{})))
  (testing "Non-intersecting sets should return the target set"
    (is (= (glom-sets #{"target"} #{"additional"}) #{"target"})))
  (testing "Intersecting sets should return the union of the two sets"
    (is (= (glom-sets #{"1" "2"} #{"2" "3"}) #{"1" "2" "3"})))
  (testing "Targeting an empty set should produce an empty set"
    (is (= (glom-sets #{} #{"2" "3"}) #{})))
  (testing "Add an empty set should produce the target set"
    (is (= (glom-sets #{"1" "2"} #{}) #{"1" "2"}))))

(deftest -main-test
  (testing "The function -main should be defined"
    (is (function? -main))))