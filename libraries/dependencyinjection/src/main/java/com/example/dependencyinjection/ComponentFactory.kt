package com.example.dependencyinjection

abstract class ComponentFactory<T> {
    abstract fun create(): T
}