## LinkList介绍
  采用线性链表中单链表数据结构：


## 源码分析
- 内部类 节点类
      private static class Node<E> {
          E item;           //当前数据节点中元素
          Node<E> next;     //下一个节点
          Node<E> prev;     //上一个节点

          Node(Node<E> prev, E element, Node<E> next) {
              this.item = element;
              this.next = next;
              this.prev = prev;
          }
      }

- add方法
      void linkLast(E e) {
          final Node<E> l = last; //获取上一个节点对象
          final Node<E> newNode = new Node<>(l, e, null);   //根据传入对象，添加一个新的节点
          last = newNode;         //让新节点替换上一个记录节点对象，因为当前节点只需要和上一个节点关联就够了
          if (l == null)          // 如果上一个节点等于空，当前节点对象就是firtNode
            first = newNode;
          else
            l.next = newNode;     //反之，当前节点是上一个节点的next节点
          size++;
          modCount++;
      }
