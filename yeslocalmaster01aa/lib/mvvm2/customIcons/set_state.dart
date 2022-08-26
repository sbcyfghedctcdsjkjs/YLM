
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyList());

class Item {
  Item({this.name, this.isFavorite});

  String name;
  bool isFavorite;
}

class MyList extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => MyListState();
}

class MyListState extends State<MyList> {
  List<Item> items;

  @override
  void initState() {
    super.initState();

    // Generate example items
    items = List<Item>();
    for (int i = 0; i < 100; i++) {
      items.add(Item(
        name: 'Item $i',
        isFavorite: false,
      ));
    }
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(

      itemCount: items.length,
      itemBuilder: (context, index) {
        return ListItem(

          items[index],
              () => onFavoritePressed(index),
        );
      },
    );
  }

  onFavoritePressed(int index) {
    final item = items[index];
    setState(() {
      item.isFavorite = !item.isFavorite;
    });
  }
}

class ListItem extends StatelessWidget {
  ListItem(this.item, this.onFavoritePressed);

  final Item item;
  final VoidCallback onFavoritePressed;

  @override
  Widget build(BuildContext context) {
    return ListTile(
      title: Text(item.name),

      leading: IconButton(
        icon: Icon(item.isFavorite ? Icons.favorite : Icons.favorite_border),
        onPressed: onFavoritePressed,
      ),
    );
  }
}
