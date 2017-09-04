package com.broilogabriel

import org.scalatest.{FlatSpecLike, Matchers}

class RakeTest extends FlatSpecLike with Matchers {

  "Rake" should "extract key phrases from text" in {
    // @formatter:off
    val text = "Compatibility of systems of linear constraints over the set of natural numbers. Criteria of compatibility of a system of linear Diophantine equations, strict inequations, and nonstrict inequations are considered. Upper bounds for components of a minimal set of solutions and algorithms of construction of minimal generating sets of solutions for all types of systems are given. These criteria and the corresponding algorithms for constructing a minimal supporting set of solutions can be used in solving all the considered types of systems and systems of mixed types."
    val expected = Set(("minimal generating sets", 8.666666666666666), ("linear diophantine equations", 8.5), ("minimal supporting set", 7.666666666666666), ("minimal set", 4.666666666666666), ("linear constraints", 4.5), ("natural numbers", 4.0), ("strict inequations", 4.0), ("nonstrict inequations", 4.0), ("upper bounds", 4.0), ("mixed types", 3.666666666666667), ("considered types", 3.166666666666667), ("set", 2.0), ("types", 1.6666666666666667), ("considered", 1.5), ("compatibility", 1.0), ("systems", 1.0), ("criteria", 1.0), ("system", 1.0), ("components", 1.0), ("solutions", 1.0), ("algorithms", 1.0), ("construction", 1.0), ("constructing", 1.0), ("solving", 1.0))
    // @formatter:on

    val ret = Rake.run(text)
    ret.toList.sortWith(_._2 > _._2).foreach(w =>
      println(s"- $w")
    )
    assert(ret.size == 24)
    assert(ret.toSet == expected)
  }

}
