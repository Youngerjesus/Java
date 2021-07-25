package com.example.java.java11;

public class NestBasedAccessControl {

    private void outerPrivate() {
        System.out.println("Outer Private");
    }

    public class Inner {

        public void innerPublic() {
            outerPrivate();
        }
    }
}
