(ns hello.core-test
  (:require [clojure.test :refer [deftest is testing]]))

(deftest name-test
  (testing "Context of the test assertions"
    (is (= 1 1))))
