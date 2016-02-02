# coding=utf-8
# --------------------------------------------------------------------------
# Copyright (c) Microsoft Corporation. All rights reserved.
# Licensed under the MIT License. See License.txt in the project root for
# license information.
#
# Code generated by Microsoft (R) AutoRest Code Generator.
# Changes may cause incorrect behavior and will be lost if the code is
# regenerated.
# --------------------------------------------------------------------------

from msrest.serialization import Model


class Foo(Model):
    """
    The URIs that are used to perform a retrieval of a public blob, queue or
    table object.

    :param Bar bar_point: Bar point
    """

    _required = []

    _attribute_map = {
        'bar_point': {'key': 'BarPoint', 'type': 'Bar'},
    }

    def __init__(self, *args, **kwargs):
        self.bar_point = None

        super(Foo, self).__init__(*args, **kwargs)
