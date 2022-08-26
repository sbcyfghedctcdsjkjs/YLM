// DO NOT EDIT. This is code generated via package:intl/generate_localized.dart
// This is a library that looks up messages for specific locales by
// delegating to the appropriate library.

// Ignore issues from commonly used lints in this file.
// ignore_for_file:implementation_imports, file_names, unnecessary_new
// ignore_for_file:unnecessary_brace_in_string_interps, directives_ordering
// ignore_for_file:argument_type_not_assignable, invalid_assignment
// ignore_for_file:prefer_single_quotes, prefer_generic_function_type_aliases
// ignore_for_file:comment_references

import 'dart:async';

import 'package:intl/intl.dart';
import 'package:intl/message_lookup_by_library.dart';
import 'package:intl/src/intl_helpers.dart';

import 'messages_bng.dart' as messages_bng;
import 'messages_en.dart' as messages_en;
import 'messages_gj.dart' as messages_gj;
import 'messages_hi.dart' as messages_hi;
import 'messages_kn.dart' as messages_kn;
import 'messages_ml.dart' as messages_ml;
import 'messages_mr.dart' as messages_mr;
import 'messages_pa.dart' as messages_pa;
import 'messages_ta.dart' as messages_ta;
import 'messages_te.dart' as messages_te;
import 'messages_ur.dart' as messages_ur;

typedef Future<dynamic> LibraryLoader();
Map<String, LibraryLoader> _deferredLibraries = {
  'bng': () => new Future.value(null),
  'en': () => new Future.value(null),
  'gj': () => new Future.value(null),
  'hi': () => new Future.value(null),
  'kn': () => new Future.value(null),
  'ml': () => new Future.value(null),
  'mr': () => new Future.value(null),
  'pa': () => new Future.value(null),
  'ta': () => new Future.value(null),
  'te': () => new Future.value(null),
  'ur': () => new Future.value(null),
};

MessageLookupByLibrary _findExact(String localeName) {
  switch (localeName) {
    case 'bng':
      return messages_bng.messages;
    case 'en':
      return messages_en.messages;
    case 'gj':
      return messages_gj.messages;
    case 'hi':
      return messages_hi.messages;
    case 'kn':
      return messages_kn.messages;
    case 'ml':
      return messages_ml.messages;
    case 'mr':
      return messages_mr.messages;
    case 'pa':
      return messages_pa.messages;
    case 'ta':
      return messages_ta.messages;
    case 'te':
      return messages_te.messages;
    case 'ur':
      return messages_ur.messages;
    default:
      return null;
  }
}

/// User programs should call this before using [localeName] for messages.
Future<bool> initializeMessages(String localeName) async {
  var availableLocale = Intl.verifiedLocale(
    localeName,
    (locale) => _deferredLibraries[locale] != null,
    onFailure: (_) => null);
  if (availableLocale == null) {
    return new Future.value(false);
  }
  var lib = _deferredLibraries[availableLocale];
  await (lib == null ? new Future.value(false) : lib());
  initializeInternalMessageLookup(() => new CompositeMessageLookup());
  messageLookup.addLocale(availableLocale, _findGeneratedMessagesFor);
  return new Future.value(true);
}

bool _messagesExistFor(String locale) {
  try {
    return _findExact(locale) != null;
  } catch (e) {
    return false;
  }
}

MessageLookupByLibrary _findGeneratedMessagesFor(String locale) {
  var actualLocale = Intl.verifiedLocale(locale, _messagesExistFor,
      onFailure: (_) => null);
  if (actualLocale == null) return null;
  return _findExact(actualLocale);
}
